export default {
    name: "chatRoomList",
    components: [],
    data() {
        return {
            connectData: "",
        };
    },
    mounted() {
        this.get();
    },
    methods: {
        get() {
            this.axios.get("/rooms").then((response) => {
                this.connectData = response.data;
            });
        },
    },
}