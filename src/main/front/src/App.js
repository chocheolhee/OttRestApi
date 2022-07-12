import "./App.css";
import { Navbar, Container, Nav } from "react-bootstrap";
import { Routes, Route, useNavigate } from "react-router-dom";
import AddParty from "./routes/AddParty";
import MainPage from "./routes/MainPage";
import MyParty from "./routes/MyParty";
import Guide from "./routes/Guide";

function App() {
    let navigate = useNavigate();

    return (
        <div className="App">
            <Navbar collapseOnSelect expand="lg" bg="light" variant="light">
                <Container>
                    <Navbar.Brand href="/">Pickle+</Navbar.Brand>
                    <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                    <Navbar.Collapse id="responsive-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link
                                onClick={() => {
                                    navigate("/");
                                }}
                            >
                                홈
                            </Nav.Link>
                            <Nav.Link href="/addParty">파티추가</Nav.Link>
                            <Nav.Link href="/myParty">My파티</Nav.Link>
                            <Nav.Link href="/guide">가이드</Nav.Link>
                        </Nav>
                        <Nav>
                            <Nav.Link href="/login">로그인</Nav.Link>
                            <Nav.Link href="/register">회원가입</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>

            <Routes>
                <Route path="/" element={<MainPage />} />
                <Route path="/addParty" element={<AddParty />} />
                <Route path="/myParty" element={<MyParty />} />
                <Route path="/guide" element={<Guide />} />
            </Routes>
        </div>
    );
}

export default App;
