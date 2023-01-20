        var op_region=document.getElementById("region");
        var op_ecole=document.getElementById("school");
        var div=document.getElementById("popup");
        var ecoleLs=null;
    function regionEcole(){
        console.log(div);
        div.style="";
    $.getJSON("ChoixEcole",function(data){
        console.log(data);
        ecoleLs=data.ecole;
        Region(data.region);
        ecole();
    })
}
function Region(region){
        let option="";
    for(let r=0;r<region.length;r++){
        option+="<option value=\""+region[r].idRegion+"\" >"+ region[r].nom+"</option>";
    }
    op_region.innerHTML=option;
}
function ecole(){
        op_region=document.getElementById("region");
        let id=op_region.value;
        let option="";
        for(let r=0;r<ecoleLs.length;r++){
            if(ecoleLs[r].idRegion==id){
            option+="<option value=\""+ecoleLs[r].idEcole+"\" >"+ ecoleLs[r].nom+"</option>";
            }
        }
        console.log(option);
        console.log(op_ecole);
        op_ecole.innerHTML=option;
}