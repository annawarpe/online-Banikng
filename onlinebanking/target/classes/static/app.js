// LOGOUT LOGIC
document.addEventListener('DOMContentLoaded', () => {

    const logoutBtn = document.getElementById('logoutBtn');

    if(logoutBtn){
        logoutBtn.addEventListener('click', function(e){
            e.preventDefault();

            // Clear any session data if using localStorage (optional)
            localStorage.clear();

            // Optional: show message
            alert("You have been logged out successfully!");

            // Redirect to Home Page
            window.location.href = 'home.html';
        });
    }

});
