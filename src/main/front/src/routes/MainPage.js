import React from "react";
import bg from "../img/bg.png";
import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";

function MainPage() {
    let navigate = useNavigate();

    return (
        <div className="main-bg" style={{ backgroundImage: "url(" + bg + ")" }}>
            <div style={{ color: "white", padding: "10px", fontSize: "20px" }}>피클플러스 입니다.</div>
            <Button
                variant="outline-success"
                onClick={() => {
                    navigate("/addParty");
                }}
            >
                시작하기
            </Button>
        </div>
    );
}

export default MainPage;
