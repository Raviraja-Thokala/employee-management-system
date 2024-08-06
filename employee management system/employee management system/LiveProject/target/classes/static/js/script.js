document.getElementById('registerForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const email = document.querySelector('input[name="email"]').value;
    const password = document.querySelector('input[name="password"]').value;
    const confirmPassword = document.querySelector('input[name="confirm-password"]').value;
    const role = document.querySelector('select[name="role"]').value;

    if (password !== confirmPassword) {
        document.getElementById('error-message').style.display = 'block';
        return;
    } else {
        document.getElementById('error-message').style.display = 'none';
    }

    const data = {
        email: email,
        password: password,
        role: role
    };

    fetch('user/register', {  
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (response.ok) {
            alert('Registration successful!');
            window.location.href = 'login.html';
        } else {
            alert('Registration failed!');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('An error occurred!');
    });
});
