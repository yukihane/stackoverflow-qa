sudo yum -y update
sudo yum -y groupinstall "Development Tools"
sudo yum -y install gdbm-devel openssl-devel readline-devel zlib-devel

# SQLite >= 3.8 インストール(ここでは最新版の3.31.1をインストール)
# https://www.sqlite.org/download.html
curl -s https://www.sqlite.org/2020/sqlite-autoconf-3310100.tar.gz | tar xz -C /tmp
cd /tmp/sqlite-autoconf-3310100
./configure --prefix=/usr/local
make
sudo make install

# nodejs v12(LTS) インストール
# https://nodejs.org/ja/download/package-manager/#debian-and-ubuntu-based-linux-distributions-enterprise-linux-fedora-and-snap-packages より
# https://github.com/nodesource/distributions/blob/master/README.md#rpminstall
curl -sL https://rpm.nodesource.com/setup_12.x | sudo bash -
sudo yum -y install nodejs

# yarn インストール
# https://classic.yarnpkg.com/en/docs/install/#centos-stable
curl --silent --location https://dl.yarnpkg.com/rpm/yarn.repo | sudo tee /etc/yum.repos.d/yarn.repo
sudo yum -y install yarn

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
rbenv install 2.7.1
rbenv global 2.7.1

# sqlite3 最新版利用設定
# https://url4u.jp/centos7-rails6-sqlite3/
bundle config build.sqlite3 "--with-sqlite3-lib=/usr/local/lib"

# rails インストール
# https://guides.rubyonrails.org/getting_started.html#installing-rails
gem install rails
