let l_stones: number[] = [];
let index = 0;
let A0: Position = null;
player.onChat("comehere", function () {
  agent.teleportToPlayer();
});
player.onChat("1", function () {
  for (let index2 = 0; index2 < 4; index2++) {
    _1();
  }
});
function _1() {
  l_stones = [STONE, GRASS, WOOL];
  for (let index2 = 0; index2 < 5; index2++) {
    index = 0;
    A0 = agent.getPosition();
    for (let index2 = 0; index2 < l_stones.length; index2++) {
      blocks.place(l_stones[index], positions.add(A0, pos(0, index, 0)));
      index += 1;
    }
    agent.move(FORWARD, 2);
  }
  agent.turn(RIGHT_TURN);
}
