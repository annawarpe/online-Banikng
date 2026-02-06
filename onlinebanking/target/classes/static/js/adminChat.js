function loadAdminMessages(){

fetch("http://localhost:8080/api/messages")
.then(r=>r.json())
.then(data=>{

let box=document.getElementById("adminChatBox");
box.innerHTML="";

data.forEach(m=>{
box.innerHTML+=`<p><b>${m.sender}:</b> ${m.content}</p>`;
});

box.scrollTop=box.scrollHeight;

});
}

function sendAdminMessage(){

let msg=document.getElementById("adminMessageInput").value;

fetch("http://localhost:8080/api/messages",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({
sender:"Admin",
content:msg
})
});

document.getElementById("adminMessageInput").value="";
}

setInterval(loadAdminMessages,2000);
loadAdminMessages();
