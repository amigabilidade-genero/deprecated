module.exports = function(application) {
    //rota do index
    application.get('/', function(req, res) {
        application.src.controllers.home.home(application, req, res);
    });
};
