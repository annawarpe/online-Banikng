function register(e){

e.preventDefault();

let p=document.getElementById("pass").value;
let cp=document.getElementById("cpass").value;

if(p!==cp){
alert("Password mismatch");
return;
}

fetch("http://localhost:8080/api/register",{

method:"POST",
headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({

name:document.getElementById("name").value,
email:document.getElementById("email").value,
mobile:document.getElementById("mobile").value,
accountType:document.getElementById("type").value,
address:document.getElementById("address").value,
password:p

})

})
.then(r=>r.text())
.then(msg=>{
alert(msg);
if(msg.includes("success")){
window.location.href="user-login.html";
}
});
}
