module.exports = function (application) {
    //rota do blog
    application.get('/blog', function (req, res) {
        application.src.controllers.blog.blog(application, req, res);
    });
};