var vue = new Vue({
        el: "#log_table",
        data: {
            logs: [],
            departments: [],
            log: {
                logId: '',
                userName: '',
                visitModel: '',
                visitTime: '',
                behaviour: ''
            },
            currentPage: 1,
            pageSize: 5,
        },
        methods: {
            init() {
                //加载列表
                axios.get(`http://localhost:8080/log/findAll?currentPage=${this.currentPage}&pageSize=${this.pageSize}`).then(result => {

                    this.logs = result.data.list;
                    paging(result.data.total, result.data.pages, result.data.currentPage);
                })
            },
            search() {
                axios({
                    url: 'http://localhost:8080/role/findRoleById',
                    data: this.user,
                    method: 'post',
                    headers: {contentType: "application/json"}
                }).then(result => {
                        console.log(result.data)
                    }
                )
            },
            updaterole(roleId) {
                axios({
                    url: `http://localhost:8080/role/findRoleById?roleId=${roleId}`,
                    method: 'get',
                    // headers: {contentType: "application/json"}
                }).then(result => {
                    this.role = result.data;

                    $("#roleEdit").modal('show');
                })
            },
            saveChange() {
                if (!this.role.roleId) {//roleId不存在则为添加
                    axios({
                        url: 'http://localhost:8080/role/addRole',
                        data: this.role,
                        method: 'post',
                        headers: {contentType: "application/json"}
                    }).then(result => {
                        console.log(result)
                    })

                    return;
                }
                // var formDate = new FormData();
                // for (item in this.role) {
                //     formDate.append(item, this.role[item])
                // }

                //axios.put('http://localhost:8080/role/updateRole', this.role).then(result => console.log(result.data))
                axios({
                    url: 'http://localhost:8080/role/updateRole',
                    data: this.role,
                    method: 'put',
                    headers: {contentType: "application/json"}
                }).then(result => {
                    console.log(result)
                })
            },
            addrole() {
                this.role = {}
                $("#roleEdit").modal('show');
            },
            deleterole(roleId) {
                axios.delete(`http://localhost:8080/role/deleteRole?roleId=${roleId}`).then(result =>
                    JumpToPage(this.currentPage))
            }
        },
        created() {
            this.init()
        }
    }
)

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
        url: `http://localhost:8080/log/findAll?currentPage=${pagenum}&pageSize=${vue.pageSize}`,
        method: 'get'
    }
    axios(config).then(result => vue.logs = result.data.list)
}