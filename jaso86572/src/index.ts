type Image = {
  [key: `url${number}`]: string[];
  hoge1: string;
  hoge2: string;
  // ...
};

const images: Image[] = [
  {
    url123: ["path/to/a", "path/to/b"], // 裏表のある画像へのパスになっています
    hoge1: "hoge1",
    hoge2: "hoge2",
    // ...
  },
  {
    url456: ["path/to/a", "path/to/b"],
    hoge1: "hoge1",
    hoge2: "hoge2",
    // ...
  },
  {
    url789: ["path/to/a", "path/to/b"],
    hoge1: "hoge1",
    hoge2: "hoge2",
    // ...
  },
];

const id = 123;
console.log(images[0][`url${id}`][0]); // "path/to/a"
