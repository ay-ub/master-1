let numbers = [];
const LENGTH = [10, 100, 1000, 10000, 100000, 1000000];
const getRandomNumber = () => {
  return Math.floor((Math.random() * 1000) % 1000);
};

const fillTable = (numbers, size) => {
  for (let index = 0; index < size; index++) {
    numbers[index] = getRandomNumber();
  }
};

// sort table
const sortTable = (numbers) => {
  return numbers.sort((a, b) => a - b);
};
// get complexity time
const getComplexityTime = (cb, numbers, num, startInd, endInd) => {
  let start = performance.now();
  sortTable(numbers);
  cb(numbers, num, startInd, endInd);
  let end = performance.now();
  return `Time taken: ${(end - start).toFixed(4)} milliseconds`;
};

const recherchSeq = (numbers, num, startInd, endInd) => {
  if (numbers.length === 0) {
    console.log("Tableau vide");
    return;
  } else {
    for (let index = startInd; index <= endInd; index++) {
      if (numbers[index] === num) {
        // console.log(`Le nombre ${num} est trouvé à l'indice ${index}`);
        return;
      }
    }
  }
};

const getMiddleIndex = (numbers, start, end) => {
  let startIndex = start || 0;
  let endIndex = end || numbers.length - 1;
  return Math.floor((startIndex + endIndex) / 2);
};

const recherchDechoIte = (numbers, num, startInd, endInd) => {
  if (numbers.length === 0) {
    console.log("Tableau vide");
    return;
  } else {
    let start = startInd || 0;
    let end = endInd || numbers.length - 1;
    let middle;
    while (start <= end) {
      middle = getMiddleIndex(numbers, start, end);
      if (numbers[middle] === num) {
        // console.log(`Le nombre ${num} est trouvé à l'indice ${middle}`);
        return;
      } else if (numbers[middle] < num) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }
  }
};

// const recherchDechoRec = (numbers, num, start, end) => {
//   // if (numbers.length === 0) {
//   //   console.log("Tableau vide");
//   //   return;
//   // } else {
//   //   let middle = getMiddleIndex(numbers, start, end);
//   //   if (numbers[middle] === num) {
//   //     console.log(`Le nombre ${num} est trouvé à l'indice ${middle}`);
//   //     return;
//   //   } else if (numbers[middle] < num) {
//   //     return recherchDechoRec(numbers, num, middle + 1, end);
//   //   } else {
//   //     return recherchDechoRec(numbers, num, start, middle - 1);
//   //   }
//   // }
// };

LENGTH.forEach((length) => {
  fillTable(numbers, length);
  sortTable(numbers);
  let num = getRandomNumber();
  let startInd = 0;
  let endInd = length - 1;
  let result = {
    recherchSeq: getComplexityTime(recherchSeq, numbers, num, startInd, endInd),
    recherchDechoIte: getComplexityTime(
      recherchDechoIte,
      numbers,
      num,
      startInd,
      endInd
    ),
    //   recherchDechoRec: getComplexityTime(
    //     recherchDechoRec,
    //     numbers,
    //     num,
    //     startInd,
    //     endInd
    //   ),
  };
  console.log(`Tableau de taille ${length}`);
  console.log(result);
  console.log("=".repeat(50));
});
