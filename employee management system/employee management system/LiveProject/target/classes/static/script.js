document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Dummy check for demonstration (replace with actual authentication)
    if(username === 'admin' && password === 'password') {
        document.querySelector('.login-container').style.display = 'none';
        document.querySelector('.dashboard-container').style.display = 'block';
    } 
    else {
        alert('Invalid username or password');
    }
});



function myFunction() {
  document.getElementById("demo").innerHTML = "";
}

// dashbar

function openNav() {
    document.getElementById("sidebar").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("sidebar").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}


