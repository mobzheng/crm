var vue = new Vue({
    el: "#login",
    data: {
        user: {userName: '', password: ''},
        code: ''
    },
    methods: {
        login() {


            axios({
                url: `http://localhost:8080/user/login`,
                data: this.user,
                method: 'post',
                headers: {
                    contentType: 'application/json'
                }
            }).then(result => {
                if (result.data == 'success') {
                    $.sendSuccessToTop('登录成功', 50, function () {
                        window.location.href = '../html/index.html';
                    });
                }
            })
        },
        register() {

        },
        getCode() {

        }
    },
    created() {

    }
});