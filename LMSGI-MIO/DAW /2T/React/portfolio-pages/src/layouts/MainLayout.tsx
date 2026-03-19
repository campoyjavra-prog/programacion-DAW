import { NavBar } from "../components/NavBar";
import { Outlet } from "react-router-dom";

export const MainLayout = () => {
    return (
        <>
            <div >
                <header>
                    <NavBar />
                </header>

                <main>
                    <Outlet />
                </main>


                <footer>
                    <p>© 2026 Portfolio Pages. All rights reserved.</p>
                </footer>
            </div>
        </>
    )
}