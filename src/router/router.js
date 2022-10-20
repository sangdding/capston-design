import { createWebHistory, createRouter } from "vue-router";
import AgoraView from "@/views/AgoraView";

const router = createRouter({
    history : createWebHistory(),
    routes : [ // path별 cogit mponent를 추가한다.
        {
            path: "/agora",
            name: "agora",
            component: AgoraView
        }
    ]
});

export default router;