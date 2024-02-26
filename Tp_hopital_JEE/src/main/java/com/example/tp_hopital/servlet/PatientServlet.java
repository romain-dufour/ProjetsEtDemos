package com.example.tp_hopital.servlet;

import com.example.tp_hopital.entities.Consultation;
import com.example.tp_hopital.entities.FicheDeSoin;
import com.example.tp_hopital.entities.Patient;
import com.example.tp_hopital.entities.Prescription;
import com.example.tp_hopital.services.ConsultationService;
import com.example.tp_hopital.services.FicheDeSoinService;
import com.example.tp_hopital.services.PatientService;
import com.example.tp_hopital.services.PrescriptionService;
import com.example.tp_hopital.utils.Definition;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

@WebServlet("/")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class PatientServlet extends HttpServlet {

    private PatientService servicePatient;
    private ConsultationService serviceConsultation;
    private FicheDeSoinService serviceFicheDeSoin;
    private PrescriptionService servicePrescription;

    public void init() {
        servicePatient = new PatientService();
        serviceConsultation = new ConsultationService();
        servicePrescription = new PrescriptionService();
        serviceFicheDeSoin = new FicheDeSoinService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        boolean logged = (session.getAttribute("isLogged") != null) ? (boolean) session.getAttribute("isLogged") : false;

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/newPatient":
                    showNewFormPatient(request, response);
                    break;

                case "/newConsultation":
                    showNewFormConsultation(request, response);
                    break;
                case "/newFicheDeSoin":
                    showNewFormFiche(request, response);
                    break;
                case "/newPrescription":
                    showNewFormPrescription(request, response);
                    break;
                case "/insert_patient":
                    insertPatient(request, response);
                    break;
                case "/insert_consultation":
                    insertConsultation(request, response);
                    break;
                case "/insert_fiche_de_soin":
                    insertfiche(request, response);
                    break;
                case "/insert_prescription":
                    insertprescription(request, response);
                    break;
                case "/patientList":
                    patientList(request, response);
                    break;
                case "/detailsPatient":
                    patientDetails(request, response);
                    break;
                case "/detailsConsultation":
                    consultationDetails(request, response);
                    break;




            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    private void consultationDetails(HttpServletRequest request, HttpServletResponse response)
            throws Exception{

        if (request.getParameter("id") != null) {
            Long id = Long.parseLong((request.getParameter("id")));
            Consultation consultation = serviceConsultation.findById(id);
            request.setAttribute("consultation", consultation);
            request.getRequestDispatcher(Definition.VIEW_PATH + "details-consultation.jsp").forward(request, response);
        } else {
            String lastName = request.getParameter("search");
            request.setAttribute("patient", servicePatient.filterByLastName(lastName));
            request.getRequestDispatcher(Definition.VIEW_PATH + "patients.jsp").forward(request, response);
        }
    }


    private void showNewFormPatient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH+"form-patient.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormConsultation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH+"form-consultation.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormFiche(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH+"form-ficheDeSoin.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormPrescription(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Definition.VIEW_PATH+"form-prescription.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPatient(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        Part photoPart = request.getPart("picture");

        String fileType = photoPart.getContentType();

        if (fileType.equalsIgnoreCase("picture/jpg")) {

            byte[] imageBytes = null;
            if (photoPart != null) {
                InputStream inputStream = photoPart.getInputStream();
                imageBytes = inputStream.readAllBytes();
            }


            String lastName = request.getParameter("lastName");
            String firstName = request.getParameter("firstName");
            LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));

          //  Patient patient = new Patient(lastName, firstName, Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant()), imageBytes);
Patient patient = new Patient(lastName,firstName,Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            if (servicePatient.create(patient)) {
                response.sendRedirect("patientlist");
            } else {
                response.sendRedirect(Definition.VIEW_PATH + "form-patient.jsp");
            }
        } else {
            response.sendRedirect(Definition.VIEW_PATH + "form-patient.jsp");
        }
    }

    private void insertConsultation(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {


        Long id_patient = Long.parseLong(request.getParameter("patientId"));
        LocalDate consultDate = LocalDate.parse(request.getParameter("consultDate"));
        String doctorName = request.getParameter("doctorName");

        Patient patient = this.servicePatient.findById(id_patient);

        Consultation consultation = new Consultation(Date.from(consultDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),doctorName,patient);

        if (serviceConsultation.create(consultation)) {
            response.sendRedirect("consultationList");
        } else {
            response.sendRedirect(Definition.VIEW_PATH + "form-consultation.jsp");
        }
    }


    private void insertfiche(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        Long consultation_id = Long.parseLong(request.getParameter("consultationId"));
        String doctorName = request.getParameter("inputTypeOfCare");
        int duration = Integer.parseInt(request.getParameter("duration"));


        Consultation consultation = this.serviceConsultation.findById(consultation_id);

        FicheDeSoin ficheDeSoin = new FicheDeSoin(doctorName,duration,consultation);

        if (serviceFicheDeSoin.create(ficheDeSoin)) {
            response.sendRedirect("consultationList");
        } else {
            response.sendRedirect(Definition.VIEW_PATH + "form-ficheDeSoin.jsp");
        }
    }

    private void insertprescription(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        Long consultation_id = Long.parseLong(request.getParameter("consultationId"));
        String medicType = request.getParameter("medicType");
        int duration = Integer.parseInt(request.getParameter("duration"));


        Consultation consultation = this.serviceConsultation.findById(consultation_id);

        Prescription prescription  = new Prescription(medicType,duration,consultation);

        if (servicePrescription.create(prescription)) {
            response.sendRedirect("consultationList");
        } else {
            response.sendRedirect(Definition.VIEW_PATH + "form-prescription.jsp");
        }
    }


    private void patientList(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String lastName = request.getParameter("search");
        request.setAttribute("patient", servicePatient.filterByLastName(lastName));
        request.getRequestDispatcher(Definition.VIEW_PATH+"patients.jsp").forward(request,response);
    }

    private void patientDetails(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        if(request.getParameter("id") != null) {
            Long id = Long.parseLong((request.getParameter("id")));
            Patient patient = servicePatient.findById(id);
            request.setAttribute("patient", patient);
            request.getRequestDispatcher(Definition.VIEW_PATH+"details-patient.jsp").forward(request,response);
        }
        else {
            String lastName = request.getParameter("search");
            request.setAttribute("patient", servicePatient.filterByLastName(lastName));
            request.getRequestDispatcher(Definition.VIEW_PATH+"patients.jsp").forward(request,response);
        }
    }



}
