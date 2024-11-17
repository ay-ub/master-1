const express = require("express");
const fs = require("fs");
const app = express();
app.use(express.json());

// method 1
app.post("/unix-p1", async (req, res) => {
  try {
    const { filePath } = req.body;
    if (!filePath) {
      return res.status(400).json({ message: "filePath is required" });
    }
    const firstArr = [];
    const filaContent = fs.readFileSync(filePath, "utf8");
    const lines = filaContent.split("\n");
    lines.forEach((line) => {
      firstArr.push(line);
    });

    return res.status(200).json({ firstArr });
  } catch (error) {
    console.error("error: ", error);
    return res.status(500).json({ message: "Internal server error" });
  }
});

app.post("/unix-p2", (req, res) => {
  try {
    const { filePath } = req.body;
    const fileContent = fs.readFileSync(filePath, "utf8");

    const Lines = fileContent.split("\n");
    const firstArr = [];
    for (let index = 0; index < 3; index++) {
      firstArr.push(Lines[index]);
    }
    let secArr = [];
    let totalChar = 0;

    for (let index = 3; index < Lines.length; index++) {
      const line = Lines[index];
      totalChar += line.length;
      secArr.push(line);
    }

    res.status(200).json({ firstArr, secArr, totalChar });
  } catch (error) {
    console.error("error: ", error);
    return res.status(500).json({ message: "Internal server error" });
  }
});

app.post("/unix-p3", (req, res) => {
  try {
    const { filePath } = req.body;
    const fileContent = fs.readFileSync(filePath, "utf8");
    const Lines = fileContent.split("\n");
    if (Lines.length < 3) {
      return res.status(400).json({
        status: "failed",
        message: "File should have atleast 3 lines",
      });
    }
    const firstArr = Lines.slice(0, 3);

    let restLines = Lines.slice(3, Lines.length).join("");
    if (restLines.length == 0) {
      return res.status(400).json({ firstArr });
    }
    const MAX_CHAR_IN_ARRAY = 100;
    const nbrArr = Math.ceil(restLines.length / MAX_CHAR_IN_ARRAY);
    // secArr[nbrArr][MAX_CHAR_IN_ARRAY];
    let secArr = [];
    let currentChar = 0;
    for (let index = 0; index < nbrArr; index++) {
      secArr[index] = [];
      for (let j = 0; j < MAX_CHAR_IN_ARRAY; j++) {
        if (restLines[currentChar] == null) {
          break;
        }
        secArr[index].push(restLines[currentChar]);
        currentChar++;
      }
    }
    res.status(200).json({ firstArr, secArr });
  } catch (error) {
    console.log(error);
    return res.status(500).json({ message: "Internal server error" });
  }
});
const PORT = 3000;
app.listen(PORT, () => {
  console.log("server is runing in port ", PORT);
});
