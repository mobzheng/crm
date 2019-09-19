var vue = new Vue({
    el: ".loginscreen",
    data: {
        department: [],
        user: {
            userName: '',
            password: '',
            realName: '',
            gender: '',
            phone: '',
            email: '',
            depaId: ''
        },
        code: ''
    },
    methods: {
        init() {
            axios.get('http://localhost:8080/department/findAll').then(
                result => this.department = result.data
            )
        },
        getCode() {
            axios.get(`http://localhost:8080/code/codeSend?email=${this.user.email}`).then(result => {
                // this.code = result.data;
            })
        },
        register() {
            axios.post(`http://localhost:8080/user/addUser?code=${this.code}`, this.user, {
                headers: {
                    contentType: "application/json"
                }
            }).then(result=>{
                if(result.data=="success"){
                    location.href="login.html";
                }
            })
        }
    },
    created() {
        this.init();
    }
})