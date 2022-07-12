import React, { useState, useEffect } from "react";

function AddParty() {
    const [message, setMessage] = useState("");
    useEffect(() => {
        fetch("/api/addParty")
            .then((response) => response.text())
            .then((message) => {
                setMessage(message);
            });
    }, []);

    return (
        <div>
            파티추가 페이지
            <h1 className="App-title">{message}</h1>
            <p>CORS 드디어 성공 ㅠㅠ</p>
        </div>
    );
}

export default AddParty;
