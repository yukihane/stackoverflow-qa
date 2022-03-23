defmodule Test do
  def func([], []), do: []
  def func([h1 | t1], [h2 | t2]), do: [func(h1, h2) | func(t1, t2)]
  def func(input1, input2), do: input1 * input2
end

# 例１：
ex1 = Test.func([1], [2])
# => [2] ←コンソールに上記プログラムで処理した後のリストを表示したいです。
IO.inspect(ex1, charlists: :as_lists)

# 例2：
ex2 = Test.func([[1, 2, [[2]]]], [[3, 2, [[4]]]])
# => [[3, 4, [[8]]]] ←コンソールに上記プログラムで処理した後のリストを表示したいです。
IO.inspect(ex2, charlists: :as_lists)
