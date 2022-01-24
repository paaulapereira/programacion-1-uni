$("#oi").val("hola");
$("#thisId").append("<li>Ese elemento 1</li>");

var nombres = ["Paula", "Martha", "Pablor", "Alfonso"];

// for (var i = 0; i < nombres.length; i++) {
//   $("#thisId").append("<li>" + nombres[i] + "</li>")
//
// }
//
//
// $.each(nombres, function(i, item){
//   $("#thisId").append("<li>" + item + "</li>")
// });

$("#hideTitle").on("click", function(){
  // $().show(); // NOTE: show mostra algo escondido
  // $().hide(); // NOTE: esconde algo mostrado
  // $(this).toggle(); // NOTE: this faz referencia a id já estabelecida

  alert($(this).attr("class"));

  // NOTE: el attr serve pra atribuir um valor

}); // NOTE: o on significa que quando alguma coisa estiver on vai se ativar
