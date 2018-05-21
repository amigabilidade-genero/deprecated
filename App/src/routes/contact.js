module.exports = function (application) {
    //rota do contact
    application.get('/contact', function (req, res) {
        application.src.controllers.contact.contact(application, req, res);
    });
};