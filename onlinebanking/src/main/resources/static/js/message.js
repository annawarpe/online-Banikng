function sendMessage(){

let msg=document.getElementById("messageInput").value;

fetch("http://localhost:8080/api/messages",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({
sender:"User",
content:msg
})
});

document.getElementById("messageInput").value="";
}

function loadMessages(){

fetch("http://localhost:8080/api/messages")
.then(r=>r.json())
.then(data=>{

let box=document.getElementById("chatBox");
box.innerHTML="";

data.forEach(m=>{
box.innerHTML+=`<p><b>${m.sender}:</b> ${m.content}</p>`;
});

box.scrollTop=box.scrollHeight;

});
}

setInterval(loadMessages,2000);
loadMessages();
