var vue = new Vue({
        el: "#role_table",
        data: {
            title:'修改角色信息',
            roles: [],
            departments: [],
            role: {
                roleId: '',
                roleName: '',
                roleDes: '',
                roleState: '',
                depaId: ''
            },
            currentPage: 1,
            pageSize: 5,
        },
        methods: {
            init() {
                //加载列表
                axios.get(`http://localhost:8080/role/findAll?currentPage=${this.currentPage}&pageSize=${this.pageSize}`).then(result => {
                    this.roles = result.data.list;
                    paging(result.data.total, result.data.pages, result.data.currentPage);
                })
                //加载部门列表
                axios.get('http://localhost:8080/department/findAll').then(result => this.departments = result.data)
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
                this.title = '修改角色信息';
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
                        this.role={};
                        JumpToPage(this.currentPage);
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
                    this.role={};
                    JumpToPage(this.currentPage);
                })
            },
            addrole() {
                this.role = {}
                this.title='添加角色信息';
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
        url: `http://localhost:8080/role/findAll?currentPage=${pagenum}&pageSize=${vue.pageSize}`,
        method: 'get'
    }
    axios(config).then(result => vue.roles = result.data.list)
}