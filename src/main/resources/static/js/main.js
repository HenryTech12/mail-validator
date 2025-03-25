
let validateBtn = document.querySelector('.validate');
let proceed = false;
let enableLoad = document.getElementById('icon-load');
let validField = document.querySelector('.validation');

validateBtn.addEventListener('click', (event) => {
  event.preventDefault();
    enableLoad.classList.add('load');
    
    loadParent = enableLoad.parentNode;
    loadParent.style.display = 'flex';
    
    typeWriter();
    let myForm = document.getElementById('form');
    setTimeout(() => {
      myForm.submit();
    },5000);
});

let text = 'Please hold on while we validate your email.';

let speed = 50; // Typing speed in milliseconds
let index = 0;
let typewriterElement = document.getElementById("writer");

function typeWriter() {
     if (index < text.length) {
        typewriterElement.innerHTML += text.charAt(index);
        index++;
        setTimeout(typeWriter, speed);
      } else {
        typewriterElement.style.borderRight = "none"; // Remove cursor when done
   }
}


