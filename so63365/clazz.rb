class MyClass
  def self.hash(str)
    "####{str}###"
  end

  @@patterns = [
    [Regexp.compile("(hoge)", true), lambda{|x|x}],
    [Regexp.compile("(piyo)", true), Proc.new{$1.downcase}],
    [Regexp.compile("(huga)", true), lambda{|_|"#{self.hash($1)}-hashed"}],
  ]

  def filter(text)
    @@patterns.each do |p,r|
      text = text.gsub(p, &r)
    end
    return text
  end
end

my_obj = MyClass.new
text = "HoGePiYoHuGa"
res = my_obj.filter(text)

p res
