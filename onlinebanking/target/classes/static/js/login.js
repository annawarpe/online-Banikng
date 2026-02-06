document.getElementById("loginBtn").addEventListener("click", login);

function login(){

const email=document.getElementById("email").value;
const password=document.getElementById("password").value;

fetch("http://localhost:8080/api/login",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({
email:email,
password:password
})
})
.then(res=>res.text())
.then(result=>{

if(result==="ADMIN"){
window.location.href="admin-dashboard.html";
}
else if(result==="USER"){
window.location.href="userdashboard.html";
}
else{
alert("Invalid Email or Password");
}

});
}
