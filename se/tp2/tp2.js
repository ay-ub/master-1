const fs = require("fs");
const express = require("express");

const app = express();

app.use(express.json());

app.post("/", (req, res) => {
  const { path, fileName } = req.body;
  const searchFile = (path, fileName) => {
    const files = fs.readdirSync(path);
    for (let file of files) {
      const currentPath = `${path}/${file}`;
      if (fs.statSync(currentPath).isDirectory()) {
        const result = searchFile(currentPath, fileName);
        if (result !== null) {
          return result;
        }
      } else if (file === fileName) {
        return currentPath;
      }
    }
    return null;
  };
  const result = searchFile(path, fileName);
  if (result !== null) {
    res.status(200).json({ path: result });
  } else {
    res.status(404).json({ path: "File not found" });
  }
});

app.post("/ordre", (req, res) => {
  const { path, orderBy, type } = req.body;

  const orderDir = (path, orderBy, type) => {
    const files = fs.readdirSync(path);
    const result = [];
    for (let file of files) {
      const currentPath = `${path}/${file}`;
      const stats = fs.statSync(currentPath);
      result.push({ name: file, size: stats.size, date: stats.birthtime });
    }
    if (orderBy === "name") {
      result.sort((a, b) => {
        return a.name.localeCompare(b.name);
      });
    } else if (orderBy === "size") {
      result.sort((a, b) => (a.size > b.size ? 1 : -1));
    } else if (orderBy === "date") {
      result.sort((a, b) => (a.date > b.date ? 1 : -1));
    }
    if (type === "desc") {
      return result.reverse();
    } else if (type === "asc") {
      return result;
    }
  };

  const result = orderDir(path, orderBy, type);
  res.status(200).send({ orderBy, type, files: result });
});

const PORT = 3000;
app.listen(PORT, () => {
  console.log(`Server is running on port ${PORT}`);
});
