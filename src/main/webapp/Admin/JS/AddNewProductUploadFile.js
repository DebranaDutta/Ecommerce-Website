var productPic = document.getElementById("productPic");
var productPicName = document.getElementById("productPicName");
productPic.addEventListener("change", function (event) {
  let uploadedFileName = event.target.files[0].name;
  productPicName.textContent = uploadedFileName;
});
