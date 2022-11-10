const getElement = (selector) => {
  const element = document.querySelector(selector);

  if (element) return element;
  throw Error(
    `Please double check your class names, there is no ${selector} class`
  );
};

const date = getElement("#date");
const currentYear = new Date().getFullYear();
date.textContent = currentYear;

function search(ings) {
  console.log(`
  SELECT ID
    FROM Receita
    INNER JOIN Ingrediente ON Ingrediente.Nome = Ingrediente.Nome`);
  console.log(ings[1]);
}

var ings = []; //salvar os ingredientes
var i = 0;
var j = 0;

//funcao para mostrar o ingrediente selecionado no console + mudar bg
function ingrSelec(valor) {
  const bg = document.querySelector("#" + valor);
  if (bg.style.background == "rgba(255, 191, 133, 0.5)") {
    bg.style.background = "rgba(255, 191, 133, 0.0)";

    for (i = 0; i < ings.length; i++) {
      if (ings[i] == valor) {
        for (j = i; j < ings.length; j++) {
          ings[j] = ings[j + 1];
        }
      }
    }
  } else {
    bg.style.background = "rgba(255, 191, 133, 0.5)";
    ings[ings.length + 1] = valor;
    console.log(valor);
  }
}

//funcao para animacao do hambuger menu
window.onload = function () {
  const menu_btn = document.querySelector(".hamburger");
  const hambuger_menu = document.querySelector(".hamburger-nav");

  menu_btn.addEventListener("click", function () {
    menu_btn.classList.toggle("is-active");
    hambuger_menu.classList.toggle("is-active");
  });

  funcShowIngredients();
};

var funcShowIngredients = function () {
  for (let k = 1; k <= 30; k++) {
    let theUrl = `http://localhost:6789/getIngredienteApp/${k}`;
    var response = $.ajax({
      url: theUrl,
      method: "GET",
      contentType: "text/plain",
      preocessData: false,
      success: function (resposta) {
        console.log(resposta);
      },
    }).responseText;
  }
};

let ingredientesHtml = "";

var createIngredients = function (resposta) {
  const ingInfo = resposta.split(",");
  ingredientesHtml += `
      <div id="${ingInfo[1]}" class="btn grid-item" onclick="ingrSelec('${ingInfo[1]}')">
           <img src="./icons/alho.png" />${ingInfo[1]}
      </div>
  `;
  /*
  <div id="alho" class="btn grid-item" onclick="ingrSelec('alho')">
              <img src="./icons/alho.png" />Alho
            </div>
  */
};
