import { createWebHistory, createRouter } from "vue-router";
import AgoraView from "@/views/AgoraView";
import RoomView from "@/views/RoomView";

const router = createRouter({
    history : createWebHistory(),
    routes : [ // path별 cogit mponent를 추가한다.
        {
            path: "/",
            name: "agora",
            component: AgoraView
        },
        {
            path: "/chat/room",
            name: "roomDetail",
            component: RoomView
        }
    ]
});

export default router;