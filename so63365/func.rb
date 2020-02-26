def hash(str)
  "####{str}###"
end

patterns = [
  [Regexp.compile("(hoge)", true), lambda{|x|x}],
  [Regexp.compile("(piyo)", true), Proc.new{$1.downcase}],
  [Regexp.compile("(huga)", true), lambda{|_|"#{hash($1)}-hashed"}],
]

text = "HoGePiYoHuGa"

patterns.each do |p,r|
  text = text.gsub(p, &r)
end

p text

