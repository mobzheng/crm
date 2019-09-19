var vue = new Vue({
    el: '#app',
    data: {users: [], menus: [], currentPage: 1, pageSize: 5},
    methods: {
        findAllMenu() {
            axios.get(`http://localhost:8080/menu/findMenus`).then(result => {
                console.log(result.data)
                this.menus = result.data
            })
        }
    },
    created() {
        this.findAllMenu();
    }
})