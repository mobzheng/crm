$(function () {
    var vue = new Vue({
        el: "#right_manage",
        data: {
            rid: '',
            tree: 0,
            rights: [],
            preId: []
        },
        methods: {
            init() {
                axios.get('http://localhost:8080/right/findAll').then(result =>
                    this.rights = result.data
                );
            },
            getDetail(rid) {
                this.rid = rid;
                $("#roleEdit").modal("show");
                axios.all([axios.get('http://localhost:8080/menu/findMenus'), axios.get('http://localhost:8080/menu/findMenusByrid', {params: {rid: rid}})]).then(
                    axios.spread((result0, result1) => {
                        $("#tree_list").empty();
                        let check = []
                        for (let i = 0; i < result1.data.length; i++) {
                            check.push(result1.data[i].menuId)
                        }
                        new verTree({
                            items: "#tree_list",
                            type: "form",//list:表格展示 data:一般展示 form：表单展示
                            data: result0.data,
                            parent: "pid",//菜单等级
                            params: "menuId",//input中的value
                            value: "menuName",//菜单名
                            name: "menuId",//input中的name
                            defaults: check.toString(),//需要选中的菜单ID
                            open_close: 'open'
                        });
                    })
                );
            },

            saveChange() {
                axios.put(`http://localhost:8080/right/updateRightMenu?rid=${this.rid}&${$("#my_form").serialize()}`).then(
                    result => console.log(result.data)
                )
            }
        },
        created() {
            this.init();
        }
    })
})

