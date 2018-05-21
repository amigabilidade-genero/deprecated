module.exports = function (application) {
    //rota do sobre (about)
    application.get('/about', function (req, res) {
        application.src.controllers.about.about(application, req, res);
    });
};