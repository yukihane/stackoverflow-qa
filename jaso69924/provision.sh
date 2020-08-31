sudo yum -y update
sudo yum -y groupinstall "Development Tools"
sudo yum -y install gdbm-devel openssl-devel readline-devel zlib-devel


# GCC4
pushd /tmp
curl -L -O http://ftp.tsukuba.wide.ad.jp/software/gcc/releases/gcc-4.9.4/gcc-4.9.4.tar.gz
tar xf gcc-4.9.4.tar.gz
cd gcc-4.9.4
./contrib/download_prerequisites
make -j 5
sudo make install
# https://qiita.com/knutpb1205/items/4a9b39bf69f1788ef69c#%E3%82%A8%E3%83%A9%E3%83%BC%E5%AF%BE%E7%AD%96
sudo mv /opt/gcc-4.9.4/lib64/{,bak.}libstdc++.so.6.0.20-gdb.py
sudo bash -c 'cat > /etc/ld.so.conf.d/gcc-4.9.4.conf' << EOF
/opt/gcc-4.9.4/lib64
EOF
sudo ldconfig
echo 'export PATH=/opt/gcc-4.9.4/bin:$PATH' >> ~/.bashrc
source ~/.bashrc
popd

# glibc 2.17 (nodeが必要としている)
# https://gist.github.com/harv/f86690fcad94f655906ee9e37c85b174
pushd /tmp

curl -L -O http://copr-be.cloud.fedoraproject.org/results/mosquito/myrepo-el6/epel-6-x86_64/glibc-2.17-55.fc20/glibc-2.17-55.el6.x86_64.rpm
curl -L -O http://copr-be.cloud.fedoraproject.org/results/mosquito/myrepo-el6/epel-6-x86_64/glibc-2.17-55.fc20/glibc-common-2.17-55.el6.x86_64.rpm
curl -L -O http://copr-be.cloud.fedoraproject.org/results/mosquito/myrepo-el6/epel-6-x86_64/glibc-2.17-55.fc20/glibc-devel-2.17-55.el6.x86_64.rpm
curl -L -O http://copr-be.cloud.fedoraproject.org/results/mosquito/myrepo-el6/epel-6-x86_64/glibc-2.17-55.fc20/glibc-headers-2.17-55.el6.x86_64.rpm

sudo rpm -Uvh glibc-2.17-55.el6.x86_64.rpm \
glibc-common-2.17-55.el6.x86_64.rpm \
glibc-devel-2.17-55.el6.x86_64.rpm \
glibc-headers-2.17-55.el6.x86_64.rpm

popd


# SQLite >= 3.8 インストール(ここでは3.31.1をインストール)
# https://www.sqlite.org/download.html
curl -s https://www.sqlite.org/2020/sqlite-autoconf-3310100.tar.gz | tar xz -C /tmp
cd /tmp/sqlite-autoconf-3310100
./configure --prefix=/usr/local
make
sudo make install

# nodejs v12(LTS) インストール
# https://nodejs.org/ja/download/
mkdir -p ~/opt
curl -sL https://nodejs.org/dist/v12.18.3/node-v12.18.3-linux-x64.tar.xz | tar xJ -C ~/opt
echo 'export PATH=$HOME/opt/node-v12.18.3-linux-x64/bin:$PATH' >> ~/.bashrc
source ~/.bashrc

# yarn インストール
npm install -g yarn

# rbenv, rbenv-build インストール
# https://github.com/rbenv/rbenv#basic-github-checkout
git clone https://github.com/rbenv/rbenv.git ~/.rbenv
cd ~/.rbenv && src/configure && make -C src
echo 'export PATH="$HOME/.rbenv/bin:$PATH"' >> ~/.bash_profile
echo 'eval "$(rbenv init -)"' >> ~/.bash_profile
source ~/.bash_profile
mkdir -p "$(rbenv root)"/plugins
git clone https://github.com/rbenv/ruby-build.git "$(rbenv root)"/plugins/ruby-build

# ruby インストール
rbenv install 2.6.5
rbenv global 2.6.5

# sqlite3 利用設定
# https://url4u.jp/centos7-rails6-sqlite3/
bundle config build.sqlite3 "--with-sqlite3-lib=/usr/local/lib"

# rails インストール
# https://guides.rubyonrails.org/getting_started.html#installing-rails
gem install rails
