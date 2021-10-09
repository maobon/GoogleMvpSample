package client.yalantis.com.githubclient.flow.repository_list


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import client.yalantis.com.githubclient.R
import client.yalantis.com.githubclient.model.Repository


/**
 * Created by andrewkhristyan on 10/5/16.
 */
class RepositoriesAdapter(
    private val repositories: MutableList<Repository>,
    private val onClick: (Repository) -> Unit
) : RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(repositories[position])
    }

    override fun getItemCount(): Int = repositories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repository, parent, false).let {
                ViewHolder(it, onClick)
            }
    }

    class ViewHolder(val containerView: View, private val onClick: (Repository) -> Unit) :
        RecyclerView.ViewHolder(containerView) {

        fun bindData(repository: Repository) {
            with(repository) {
                // text_view_title.text = name
                // text_view_description.text = description
                containerView.setOnClickListener { onClick(this) }
            }
        }
    }


    fun addRepositories(newRepositories: List<Repository>) {
        repositories.addAll(newRepositories)
    }
}