//forma de requisitar e chamar de forma separada
var express = require('express');
var consign = require('consign');
var bodyParser = require('body-parser');

//import do expressValidator
var expressValidator = require('express-validator');

//import do expressSession
var expressSession = require('express-session');

var application = express();

//configuracao para usar recursos staticos em public
application.use(express.static('./src/public'));

application.set('view engine', 'ejs');
application.set('views', './src/views');

//configura o middleware bodyParser no aplicativo
application.use(bodyParser.urlencoded({extended: true}));

//configura o middleware expressValidator no aplicativo
application.use(expressValidator());

//configura o middleware expressSession
application.use(
  expressSession({
    //em secret deve ser escrita qualquer coisa. de preferência ilegíveis
    secret: '@f#ãd%lkf&açdl01*92[84)7,mnç.vcxsw3wa5$637',
    resave: true,
    saveUninitialized: true,
  })
);

//configuracao do consign
consign()
  .include('config/dbConnection.js') //devemos definir o arquivo dbConnection.js porque o services (server) jah dentro de config
  .then('src/models')
  .then('src/controllers')
  .then('src/routes')
  .into(application);

module.exports = application;

//forma de requisistar e executar ao mesmo tempo
//var msg = require('./mod_teste')();
