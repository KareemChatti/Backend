import mongoose from 'mongoose';

const userSchema = new mongoose.Schema({
  email: {
    type: String,
    required: true,
    unique: true,
    trim: true,
    lowercase: true, 
    match: [/.+@.+\..+/, 'Please enter a valid email address'], 
  },
  password: {
    type: String,
    required: true,
    minlength: 6, 
  }
});




const UserModel = mongoose.model('User', userSchema);

export { UserModel };