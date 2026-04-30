import { Outlet } from "react-router-dom"
import { SidebarProvider } from "@/components/ui/sidebar"
import { AppSidebar } from "@/components/admin/AppSidebar"

export const BackLayout = () => {
    return (
        <SidebarProvider>
            <AppSidebar />
            <main className="w-full bg-white text-black min-h-screen">
                <Outlet />
            </main>
        </SidebarProvider>
    )
}
