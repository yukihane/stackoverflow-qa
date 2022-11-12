let l_stones = [STONE, GRASS, WOOL];

player.onChat("comehere", function () {
  agent.teleportToPlayer();
});

player.onChat("1", function () {
  // 4辺分繰り返す
  for (let side = 0; side < 4; side++) {
    _1();
  }
});

function _1() {
  // 4柱分繰り返す
  for (let pole = 0; pole < 4; pole++) {
    // 2歩進む
    agent.move(FORWARD, 2);
    let A0 = agent.getPosition();
    // 3ブロック(l_stones.length)積む
    for (let i = 0; i < l_stones.length; i++) {
      blocks.place(l_stones[i], positions.add(A0, pos(0, i + 1, 0)));
    }
  }
  // 右を向く
  agent.turn(RIGHT_TURN);
}
