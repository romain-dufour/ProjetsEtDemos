
export const getUserDetails = () => {
    const userItem = localStorage.getItem('user');
   // console.log("user1" + userItem);
    if (!userItem) {
        console.log("No user found in localStorage.");
        return null;
    }

    const user = JSON.parse(userItem);
    //console.log("user2" + user);

    if (!user || !user.data || !user.data.token) {
        console.log("User token not found.");
        return null;
    }

    const token = user.data.token;

    const base64Url = token.split('.')[1];
    if (!base64Url) {
        console.log("Invalid token: missing payload.");
        return null;
    }

    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    
    // Décoder la chaîne Base64 en chaîne UTF-8
    const jsonPayload = decodeURIComponent(window.atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    const decoded = JSON.parse(jsonPayload);
    //console.log(decoded);

    return { name: decoded.sub, role: decoded.roles };
};



