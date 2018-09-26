
document.addEventListener("DOMContentLoaded", function () {
    var check = function () {
        if (document.getElementById('password').value === document.getElementById('confirm_password').value && document.getElementById('password').value.length >= 4) {
            document.getElementById('message').style.color = 'grey';
            document.getElementById('message').innerHTML = 'matching';
            document.getElementById('register_button').removeAttribute('disabled');
        }
        else if (document.getElementById('password').value.length < 4) {
            document.getElementById('message').style.color = 'grey';
            document.getElementById('message').innerHTML = 'Please, enter at least four characters';
        } else {
            document.getElementById('message').style.color = 'grey';
            document.getElementById('message').innerHTML = 'not matching';
            document.getElementById('register_button').setAttribute('disabled', 'disabled');
        }
    };
    document.getElementById('password').onkeyup = check;
    document.getElementById('confirm_password').onkeyup = check;
});