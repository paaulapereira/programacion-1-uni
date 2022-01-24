var novoId = 1;
var html = "";
var books = "";
var time="";

// alert("LALALLALALLA");


//RELLENAR LA TABLA CON LOS DATOS EN LA VARIABLE "books"

books = [
{
  id: 1,
  title: "The Count of Monte Cristo",
  author: "Alexander Dumas",
  publication: "1844",
  country: "France",
  year: "before"
},
{
  id: 2,
  title: "Through the Looking-Glass",
  author: "Lewis Carroll",
  publication: "1871",
  country: "United Kingdom",
  year: "before"
},
{
  id: 3,
  title: "One Hundred Years of Solitude",
  author: "Gabriel García Márquez",
  publication: "1967",
  country: "Colombia",
  year: "after"
},
{
  id: 4,
  title: "The Brothers Karamazov",
  author: "Fyodor Dostoevsky",
  publication: "1879",
  country: "Russia",
  year: "before"
},
{
  id: 5,
  title: "Ficciones",
  author: "Jorge Luis Borges",
  publication: "1941",
  country: "Argentina",
  year: "after"
},
{
  id: 6,
  title: "Ada or Ardor: A Family Chronicle",
  author: "Vladimir Nabokov",
  publication: "1969",
  country: "USA",
  year: "after"
}
];


$(document).ready(function(){

 // drawJson();

     // $('#learning-table').append(html);
     // $('.lala').on("click", function(){
     //   alert($(this).data("bi"));
     // });


  });

      function newBook(){
        var valTitle = $("#inpTitle").val();
        var valAuthor = $("#inpAuthor").val();
        var valPublication = $("#inpPublication").val();
        var valCountry = $("#inpCountry").val();
        var valYear;

        novoId = (parseInt(books[books.length - 1].id)+1); //eso es para obtener el ultimo id de lo objeto y a este sumarle 1.

        if(valTitle != "") {
          var newHtml = "";
          newHtml += "<tr id='tr-"+novoId+"'>"; // NOTE: save as NUMBERn
          newHtml += "<td onclick='mostrarId("+novoId+")' id='title-"+novoId+"'>"+valTitle+"</td>";
          if (valAuthor=="") {
            newHtml += "<td id='author-"+novoId+"'>Anonimous</td>";
          }else {
            newHtml += "<td id='author-"+novoId+"'>"+valAuthor+"</td>";
          }
          if (valPublication == "") {
            newHtml += "<td id='publ-"+novoId+"'>Unknown</td>";
          }else {
            newHtml += "<td id='publ-"+novoId+"'>"+valPublication+"</td>";
          }
          if (valCountry == "") {
            newHtml += "<td id='country-"+novoId+"'>Unknown</td>";
          }else {
            newHtml += "<td id='country-"+novoId+"'>"+valCountry+"</td>";
          }
          newHtml += "<td><button class='chato' onclick='borrarFila("+novoId+")'>X</button></td>"; // NOTE: a essa função manda o id da fila
          newHtml += "<td><button class='chato' onclick='editarFila("+novoId+")'>Edit</button></td>"; // NOTE: a essa função manda o id da fila
          newHtml += "</tr>";


          $('#learning-table').append(newHtml);

          if(valPublication<=1900){
            valYear="before";
          }else if (valPublication>1900) {
            valYear= "after";
          }
          else{
            valYear="neither";
          }

          books.push({
            id: novoId,
            title: valTitle,
            author: valAuthor,
            publication: valPublication,
            country: valCountry,
            year: valYear
          });

          if (valYear == time) {
            $("#tr-"+novoId).show();
          } else{
            $("#tr-"+novoId).hide();
          }

          $("#inpTitle").val(" ");
          $("#inpAuthor").val(" ");
          $("#inpPublication").val(" ");
          $("#inpCountry").val(" ");
        };

      };

      $("#editar").hide();

      function mostrarId(oi){
        alert(oi);
      };

      function borrarFila(oi){
        console.log(oi);
        var newOi = "#tr-"+ oi;
        $(newOi).remove();
      };

      function editarFila(id){
        $("#editar").show();

        // console.log(books[id-1]["id"]);

        $("#inpEdTitle").val(books[id-1]["title"]);
        $("#inpEdAuthor").val(books[id-1]["author"]);
        $("#inpEdPublication").val(books[id-1]["publication"]);
        $("#inpEdCountry").val(books[id-1]["country"]);

        var button = "";
        button+= "<button type='button' id='button' onclick=añadirEditar("+id+") class='butt'> Finish Edition </button>";
        $("#editar").append(button);
      };

      function añadirEditar(id){

        var stringTitle = "#title-"+id;  //
        var stringAuthor = "#author-"+id;
        var stringPubl = "#publ-"+id;
        var stringCountry = "#country-"+id;
        var stringYear;






        $(stringTitle).html($("#inpEdTitle").val());
        books[id-1]["title"]=$("#inpEdTitle").val(); // atribui a lo que foi escrito nos inputs um valor e esse valor é igual ao titulo de cada uma das ids.
        if ($("#inpEdAuthor").val()=="") {
          $(stringAuthor).html("Anonimous");
          books[id-1]["author"]="Anonimous";
        } else {
          $(stringAuthor).html($("#inpEdAuthor").val());
          books[id-1]["author"]=$("#inpEdAuthor").val();
        }
        if ($("#inpEdPublication").val()=="") {
          $(stringPubl).html("Unknown");
          books[id-1]["publication"]="Unknown";
        } else {
          $(stringPubl).html($("#inpEdPublication").val());
          books[id-1]["publication"]=$("#inpEdPublication").val();
        }
        if ($("#inpEdCountry").val()=="") {
          $(stringCountry).html("Unknown");
          books[id-1]["country"]="Unknown";
        } else {
          $(stringCountry).html($("#inpEdCountry").val());
          books[id-1]["country"]=$("#inpEdCountry").val();
        }

        if ($("#inpEdPublication").val()== "") {
          valYear = "neither";
        }
        else if($("#inpEdPublication").val()<=1900){
          valYear="before";
        }else if ($("#inpEdPublication").val()>1900) {
          valYear= "after";
        }


        if (stringYear == time) {
          $("#tr-"+id).show();
        } else{
          $("#tr-"+id).hide();
        }

        $("#editar").hide();
        $("#button").remove();
      };

      function drawJson(fecha){
        time = fecha;
        $("#learning-table").empty();
        html = "<tr> <th>Title</th><th>Author</th>	<th>Publication</th><th>Country</th><th>Eliminate</th>  <th>Edit</th></tr>";
        $.each(books, function (key, value) {

          html += "<tr id='tr-"+value.id+"' class='success'>"; // NOTE: save as NUMBERn
          html += "<td class='lala' data-bi="+value.id+" id='title-"+value.id+"'>"+value.title+"</td>"; // NOTE: a essa função manda o id da fila
          html += "<td id='author-"+value.id+"'>"+value.author+"</td>";
          html += "<td id='publ-"+value.id+"'>"+value.publication+"</td>";
          html += "<td id='country-"+value.id+"'>"+value.country+"</td>";
          html += "<td><button class='chato' onclick='borrarFila("+value.id+")'>X</button></td>";
          html += "<td><button class='chato' onclick='editarFila("+value.id+")'>Edit</button></td>";
          html += "</tr>";
          novoId +=1;

        });
        $('#learning-table').append(html);
        // $('.lala').on("click", function(){
        //   alert($(this).data("bi"));
        // });

        if (fecha == "before") {
          mostrar1900();
        } else if(fecha == "after"){
          mostrar1901();
        }
        else{
          console.log("No funciona");
        }

      }

      function mostrar1900(){
        $.each(books, function (key, value) {
          var hideId= '#tr-'+value.id;

          if (value.publication >1900 || value.publication == "Unknown") {
             //
            $(hideId).hide();
          }else {
            $(hideId).show();
          }

        });
      }
      function mostrar1901(){
        $.each(books, function (key, value) {
          var showId= '#tr-'+value.id; //

          if (value.publication <1900 || value.publication == "Unknown") {
            $(showId).hide();
          }else {
            $(showId).show();
          }


        });
      }
      // for (var i = 0; i < books.length; i++) {
      //   console.log(books[i]);
      // }


// NOTE:  id='tr-"+value.id+"' y  data-bi="+value.id+
