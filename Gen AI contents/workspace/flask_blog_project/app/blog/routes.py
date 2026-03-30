from flask import Blueprint, render_template, request, redirect, url_for
from flask_login import current_user
from ..models import Post
from ..extensions import db

blog = Blueprint('blog', __name__)

@blog.route('/posts')
def posts():
    posts = Post.query.all()
    return render_template('posts.html', posts=posts)

@blog.route('/create', methods=['GET', 'POST'])
def create():
    if request.method == 'POST':
        post = Post(title=request.form['title'],
                    content=request.form['content'],
                    user_id=current_user.id if current_user.is_authenticated else None)
        db.session.add(post)
        db.session.commit()
        return redirect(url_for('blog.posts'))
    return render_template('create.html')
