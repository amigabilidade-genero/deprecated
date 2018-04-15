var application = require('./config/server');

var porta = 3000;

application.listen(porta, function() {
  console.log('Servidor online na porta ' + porta + '.');
});
