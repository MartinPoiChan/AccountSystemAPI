//#region _____________________________ Dependencies ________________________________
var express = require('express'),
    app     = express(),
    pug     = require('pug'),
    path    = require('path')
    draw    = pug.renderFile,
    bodyParser = require('body-parser'),
    require('dotenv').config(),
    request = require('request');
const port = 80;

app.use(bodyParser.json()); 
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'pug');

app.use(express.static('public'));
app.use(bodyParser.urlencoded({extended: true}));
//#endregion

// function getCurrency(){

// }

// ---- Ignore ----
    //#region _____________________________ Build params ________________________________
function buildParams(req, additionalData) {
    var res = {...additionalData};
    return res;
  }

//#endregion
app.get('/', (req, res) => {
  request('http://localhost:8090/account-system/mvc/currency/getAllCurrency', function(error, response, body) {
    //res.json(body)
    if (!error && response.statusCode == 200) {
      var resultTemp,result 
      resultTemp= JSON.parse(body)
      result = resultTemp.payload
      console.log(result);
    }
    return res.render('index',buildParams(req, {results:result}));
  })
})

app.post('/currency-create', function(req, res) {
  var jsonDataObj = {
    "currencyName": req.body.Name,
    "milesConv": req.body.Conversion
  };
  request.post({
      url: 'http://localhost:8090/account-system/mvc/currency/createCurrency',
      body: jsonDataObj,
      json: true
    }, function(error, response, body){
    console.log(body);
  });
  res.redirect('/')
 })

 app.post('/update-member-account-currency', function(req, res) {

  console.log(req.body.uid+'/'+req.body.cid);
  request.put({
      url: 'http://localhost:8090/account-system/mvc/memberAccount/updateCurrency/'+req.body.uid+'/'+req.body.cid,
      json: true
    }, function(error, response, body){
    console.log(body);
  });
  res.redirect('/')
 })

// Running the server
app.listen(port, function() {
    console.log("App running.....");
})
