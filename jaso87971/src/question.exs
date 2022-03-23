defmodule Test do
  def func(input1, input2) do
    funcInside(input1, input2)
  end

  # まず単純に第1引数と第2引数を掛け算して出力する
  defp funcInside(input1, input2) do
    item1 = hd input1
    item2 = hd input2
    result = item1 * item2
    IO.puts "#{outputList}" #　←　出力をどう書けばコンソールにリストのまま表示されるかわからない。
  end

#例１：
Test.func([1], [2])
#=> [2] ←コンソールに上記プログラムで処理した後のリストを表示したいです。
#例2：
Test.func([[1, 2, [[2]]]], [[3, 2, [[4]]]])
#=> [[3, 4, [[8]]]] ←コンソールに上記プログラムで処理した後のリストを表示したいです。
