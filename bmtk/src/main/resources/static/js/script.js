/*var arrCost = [];
var arrGal = [];

function listAll(){
	var xhr = new XMLHttpRequest();
	var ul = document.getElementById("gasList");
	ul.innerHTML = "";
	xhr.open('GET', 'http://localhost:8081/api/gas', true);
	//xhr.setRequestHeader('Authorization','Access-Control-Allow-Origin'); 
	xhr.responseType = 'json';
	xhr.send();
	xhr.onload = function() {
		  var responseObj = xhr.response;
		  var arr = [];
		  var arrId = [];
		  var arrMile = [];
		  var arrGal = [];
		  var arrCost = [];
		  responseObj.forEach(obj => {arr.push("ID: " + obj.id + " Total Mileage: "+ obj.totalMilage + " Gallons: " + obj.gallons + " Total Fuel Cost: " + obj.total_fuel_cost);
		  arrId.push(obj.id); arrMile.push(obj.totalMilage); arrGal.push(obj.gallons); arrCost.push(obj.total_fuel_cost);} );
		  for (var i = 0; i < arr.length; i++) {
			    var gas = arr[i];
			    var li = document.createElement('li');
			    li.appendChild(document.createTextNode(gas));
			    var btn = document.createElement('button');
			    btn.className = "editBtn";
			    btn.appendChild(document.createTextNode('Edit'));
			    li.appendChild(btn);
			    ul.appendChild(li);		    	    
			}
		  window.arrCost = arrCost;
		  window.arrGal = arrGal;
		  var buttonEdit = document.querySelectorAll('.editBtn');
			for (var i = 0; i < buttonEdit.length; i++){
			buttonEdit[i].setAttribute('id', ""+i);	
			buttonEdit[i].addEventListener('click', function(){edit(this.id,arrId,arrMile,arrGal,arrCost); });
			//console.log(buttonEdit[i].id);
			}
		};		
}

listAll();

function postEvent(mile, gallon, cost){
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'http://localhost:8081/api/create', true);
	xhr.setRequestHeader("Content-Type", "application/json");
	var data = JSON.stringify({"totalMilage": mile, "gallons": gallon, "total_fuel_cost": cost});
	xhr.send(data);
	//xhr.onload = () => alert(xhr.response);
}
	
	function newEvent(){
		var mile = document.getElementById("totalMilage").value; 
		var gallon = document.getElementById("gallons").value;
		var cost = document.getElementById("totalCost").value; 
		var ul = document.getElementById("showNewGas");    
		  
		var li = document.createElement('li');      
		li.appendChild(document.createTextNode("Milage: " + mile));
		ul.appendChild(li);
		    
		var li = document.createElement('li');      
		li.appendChild(document.createTextNode("Gallons: " + gallon));
		ul.appendChild(li);
		   
		var li = document.createElement('li');      
		li.appendChild(document.createTextNode("Cost: " + cost));
		ul.appendChild(li);
		
		postEvent(mile, gallon, cost);
		
		//listAll();
		}
	
function edit(id, arrId,arrMile,arrGal,arrCost){  
	var editHead = document.getElementById("editHead");
	
	var editMilage = document.getElementById("editMilage");
	var editGallons = document.getElementById("editGallons");
	var editCost = document.getElementById("editCost");
	var editId = document.getElementById("editId");
	
	var gasID = arrId[parseInt(id)];
	var mile = arrMile[parseFloat(id)];
	var gal = arrGal[parseFloat(id)];
	var cost = arrCost[parseFloat(id)];
	
	editMilage.placeholder = mile;
	editGallons.placeholder = gal;
	editCost.placeholder = cost;	
	editId.value = gasID;
	
	editHead.textContent = "";
	editHead.textContent = "ID: " + gasID;
	editId.value = gasID;
}

function editEvent(){
	var xhr = new XMLHttpRequest();
	xhr.open('PUT', 'http://localhost:8081/api/update/1', true);
	xhr.setRequestHeader('Content-Type', 'application/json;');
	//var data = JSON.stringify({"totalMilage": 700, "gallons": 1000.0, "total_fuel_cost": 100.0});
	//var data = JSON.stringify({"total_fuel_cost": 100});" +
	//var data = JSON.stringify({"gallons": 100});
	//var data = JSON.stringify({"totalMilage": 100});
	
	xhr.send(JSON.stringify({"totalMilage": 700.0, "gallons": 5000.0, "total_fuel_cost": 100.0}));
	
	xhr.onload = function () {
		console.log("response" + xhr.responseText);	
	}
	
	listAll();
}

function editEvent(){
	var editMilage = document.getElementById("editMilage");
	var editGallons = document.getElementById("editGallons");
	var editCost = document.getElementById("editCost");
	var editId = document.getElementById("editId");
	var mile = editMilage.value;
	var gal = editGallons.value;
	var cost = editCost.value;
	var id = editId.value;
	console.log("totalMilage " + mile + " gallons " + gal + " total_fuel_cost " + cost);
	
	var xhr = new XMLHttpRequest();
	xhr.open('PUT', 'http://localhost:8081/api/update/' +id, true);	
	xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	
	var data = JSON.stringify({"totalMilage": mile, "gallons": gal, "total_fuel_cost": cost});
	
	xhr.send(data);
	
	xhr.onload = function () {
		console.log("response" + xhr.responseText);	
	}
	
	listAll();
}

function deleteEvent(){
	var editId = document.getElementById("editId");
	var id = editId.value;
	var xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'http://localhost:8081/api/delete/'+ id, true);	
	xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");
	xhr.send();
	//listAll();
}

function totalCost(){
	var addCost = document.getElementById("addCost");
	var total = 0.0;
	for (var i = 0; i < window.arrCost.length; i++){
		if(window.arrCost[i] !== null){
		total = total + parseFloat(window.arrCost[i]);
		console.log("arr " +arrCost[i]);
		console.log("total "+ total);
		}
	}
	addCost.textContent = total.toFixed(2);
}

function totalGal(){
	var addGal = document.getElementById("addGal");
	var total = 0.0;
	for (var i = 0; i < window.arrGal.length; i++){
		if(window.arrGal[i] !== null){
		total = total + parseFloat(window.arrGal[i]);
		console.log("arr " +arrGal[i]);
		console.log("total "+ total);
		}
	}
	addGal.textContent = total.toFixed(2);
}


	
	
	
	
  
 */