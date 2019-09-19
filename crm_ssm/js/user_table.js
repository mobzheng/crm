var vue = new Vue({
    el: "#user_table",
    data: {
        users: [],
        departments: [],
        delId: '',
        user: {
            uid: '',
            userName: '',
            realName: '',
            gender: '',
            phone: '',
            depaId: '',
            password: '',
            creatDate: '',
            email: ''
        },
        currentPage: 1,
        pageSize: 5,
    },
    methods: {
        init() {
            //加载列表
            axios.get(`http://localhost:8080/user/findAllUser?currentPage=${this.currentPage}&pageSize=${this.pageSize}`).then(result => {
                this.users = result.data.list;
                paging(result.data.total, result.data.pages, result.data.currentPage);
            })
            //加载部门列表
            axios.get('http://localhost:8080/department/findAll').then(result => this.departments = result.data)
        },
        search() {
            // this.user.currentPage = this.currentPage;
            // this.user.pageSize = this.pageSize;
            axios({
                url: `http://localhost:8080/user/findUsers?currentPage=${this.currentPage}&pageSize=${this.pageSize}`,
                data: this.user,
                method: 'post',
                headers: {contentType: "application/json"}
            }).then(result => {
                    this.users = result.data
                }
            )
        },
        updateuser(uid) {
            this.user.uid = uid;
            axios({
                url: `http://localhost:8080/user/findUsers?currentPage=${this.currentPage}&pageSize=${this.pageSize}`,
                data: this.user,
                method: 'post',
                headers: {contentType: "application/json"}
            }).then(result => {
                this.user = result.data[0];
                $("#userEdit").modal('show');
            })
        },
        saveChange() {
            axios.put('http://localhost:8080/user/updateUser', this.user, {headers: {contentType: "application/json"}}).then(result => {
                this.user = {};
                JumpToPage(this.currentPage)
            });
            // axios({
            //     url: 'http://localhost:8080/user/updateUser',
            //     data: this.user,
            //     method: 'put',
            //     // headers: {contentType: "application/json"}
            // }).then(result => {
            //    console.log(result)
            // })
        },
        adduser() {

        },
        deleteuser(uid) {
            axios.delete(`http://localhost:8080/user/deleteUser?uid=${uid}`).then(result =>
                JumpToPage(this.currentPage))
        }
    },
    created() {
        this.init();
    }
})

function paging(totalData, totalPage, initPageNo) {
    $('#box').paging({
        initPageNo: initPageNo, // 初始页码
        totalPages: totalPage, //总页数
        totalCount: '合计' + totalData + '条数据', // 条目总数
        slideSpeed: 600, // 缓动速度 单位毫秒
        jump: true, //是否支持跳转
        callback: function (page) {
            // 回调函数
        }
    });
}

function JumpToPage(pagenum) {
    vue.currentPage = pagenum;
    loading(pagenum);
}

function loading(pagenum) {
    var config = {
        url: `http://localhost:8080/user/findAllUser?currentPage=${pagenum}&pageSize=${vue.pageSize}`,
        method: 'get'
    }
    axios(config).then(result => vue.users = result.data.list)
}